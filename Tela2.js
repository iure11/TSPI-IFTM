import React, { useState, useEffect } from 'react';
import { View, Text, Button, TextInput, StyleSheet } from 'react-native';

const API_URL = 'https://leilao-rest-api.herokuapp.com/itemdeleilao';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 16,
  },
  participantContainer: {
    marginBottom: 16,
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 16,
    borderRadius: 8,
  },
  participantName: {
    fontSize: 18,
    marginBottom: 8,
  },
  participantCPF: {
    fontSize: 16,
    color: '#666',
  },
  input: {
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    marginBottom: 16,
    paddingHorizontal: 8,
  },
 
});

export default function Tela2() {
  const [items, setItems] = useState([]);
  const [newItemName, setNewItemName] = useState('');
  const [newItemMinValue, setNewItemMinValue] = useState('');

  const fetchItems = async () => {
    try {
      const response = await fetch(API_URL);
      const data = await response.json();
      setItems(data);
    } catch (error) {
      console.error('Erro ao buscar itens de leilão:', error);
    }
  };

  const createItem = async () => {
    try {
      const newItem = {
        nome: newItemName,
        valorMinimo: parseFloat(newItemMinValue),
      };

      await fetch(API_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newItem),
      });
      fetchItems();
      setNewItemName('');
      setNewItemMinValue('');
    } catch (error) {
      console.error('Erro ao criar item de leilão:', error);
    }
  };

  useEffect(() => {
    fetchItems();
  }, []);

  return (
    <View style={styles.container}>
     
      <Text style={styles.title}>Novo Item de Leilão:</Text>
      <TextInput
        style={styles.input}
        placeholder="Nome"
        value={newItemName}
        onChangeText={setNewItemName}
      />
      <TextInput
        style={styles.input}
        placeholder="Valor Mínimo"
        value={newItemMinValue}
        onChangeText={setNewItemMinValue}
        keyboardType="numeric"
      />
      <Button
        title="Adicionar Item de Leilão"
        onPress={createItem}
        color="#007AFF"
      />
       <Text style={styles.title}>Lista de Itens de Leilão:</Text>
      {items.map((item) => (
        <View key={item.id} style={styles.participantContainer}>
          <Text style={styles.participantName}>{item.nome}</Text>
          <Text style={styles.participantCPF}>Valor Mínimo: {item.valorMinimo}</Text>
          <Button
            title="Excluir"
            onPress={() => deleteItem(item.id)}
            color="red"
          />
        </View>
      ))}
    </View>
  );
}
