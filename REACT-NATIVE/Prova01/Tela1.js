import React, { useState, useEffect } from 'react';
import { View, Text, Button, TextInput, StyleSheet } from 'react-native';

const API_URL = 'https://leilao-rest-api.herokuapp.com/participante';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 24
    ,
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

export default function Tela1() {
  const [participants, setParticipants] = useState([]);
  const [newParticipantName, setNewParticipantName] = useState('');
  const [newParticipantCPF, setNewParticipantCPF] = useState('');

  const fetchParticipants = async () => {
    try {
      const response = await fetch(API_URL);
      const data = await response.json();
      setParticipants(data);
    } catch (error) {
      console.error('Erro ao buscar participantes:', error);
    }
  };

  const deleteParticipant = async (id) => {
    try {
      await fetch(`${API_URL}/${id}`, {
        method: 'DELETE',
      });
      fetchParticipants(); 
    } catch (error) {
      console.error('Erro ao excluir participante:', error);
    }
  };

  const createParticipant = async () => {
    try {
      const newParticipant = {
        nome: newParticipantName,
        cpf: newParticipantCPF,
      };

      await fetch(API_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newParticipant),
      });
      fetchParticipants();
      setNewParticipantName(''); 
      setNewParticipantCPF(''); 
    } catch (error) {
      console.error('Erro ao criar participante:', error);
    }
  };

  useEffect(() => {
    fetchParticipants();
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Lista de Participantes:</Text>
      {participants.map((participant) => (
        <View key={participant.id} style={styles.participantContainer}>
          <Text style={styles.participantName}>{participant.nome}</Text>
          <Text style={styles.participantCPF}>CPF: {participant.cpf}</Text>
          <Button
            title="Excluir"
            onPress={() => deleteParticipant(participant.id)}
            color="red"
          />
        </View>
      ))}
      <Text style={styles.title}>Novo Participante:</Text>
      <TextInput
        style={styles.input}
        placeholder="Nome"
        value={newParticipantName}
        onChangeText={setNewParticipantName}
      />
      <TextInput
        style={styles.input}
        placeholder="CPF"
        value={newParticipantCPF}
        onChangeText={setNewParticipantCPF}
      />
      <Button
        title="Adicionar Participante"
        onPress={createParticipant}
        color="#007AFF"
      />
    </View>
  );
}
