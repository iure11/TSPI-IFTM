import React from "react";
import { View, Text, FlatList, Button, TouchableOpacity, StyleSheet, Image } from "react-native";

export const Cart = ({ items, getTotalPrice, removeItemFromCart }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Meu Carrinho</Text>
      {items.length === 0 ? (
        <Text style={styles.emptyCart}>Seu carrinho está vazio.</Text>
      ) : (
        <>
          <FlatList
            data={items}
            keyExtractor={(item) => item.id.toString()}
            renderItem={({ item }) => (
              <View style={styles.cartItem}>
                <Text style={styles.productName}>{item.product.name}</Text>
                <Image source={item.product.image} style={{ width: 130, height: 130 }} resizeMode="contain" />
                <Text style={styles.productQty}>Quantidade: {item.qty}</Text>
                <Text style={styles.productPrice}>
                  Preço: R$ {item.product.price.toFixed(2)}
                </Text>
                
                <TouchableOpacity
                  style={styles.removeButton}
                  onPress={() => removeItemFromCart(item.id)}
                >
                  <Text style={styles.removeButtonText}>Remover</Text>
                </TouchableOpacity>
              </View>
            )}
          />
          <Text style={styles.totalPrice}>
            Total: R$ {getTotalPrice().toFixed(2)}
          </Text>
          <Button title="Finalizar Compra" onPress={() => {}} />
        </>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 16,
  },
  emptyCart: {
    fontSize: 18,
  },
  cartItem: {
    marginBottom: 16,
  },
  productName: {
    fontSize: 18,
    fontWeight: "bold",
  },
  productQty: {
    fontSize: 16,
  },
  productPrice: {
    fontSize: 16,
  },
  removeButton: {
    backgroundColor: "red",
    padding: 8,
    borderRadius: 5,
    marginTop: 8,
  },
  removeButtonText: {
    color: "white",
    textAlign: "center",
  },
  totalPrice: {
    fontSize: 20,
    fontWeight: "bold",
    marginTop: 16,
  },
});
