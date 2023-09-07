import React, { Component } from "react";
import { FlatList, Image, ImageSourcePropType, Text, View } from "react-native";
import { Feather } from "@expo/vector-icons";

interface Item {
  image: ImageSourcePropType;
  name: string;
}

const data: Item[] = [
  { image: require("./img/01-tablelamps.png"), name: "Abajur" },
  { image: require("./img/02-ceilinglamps.png"), name: "Lâmpada" },
  { image: require("./img/03-sconces.png"), name: "Arante" },
  { image: require("./img/04-floorlamps.png"), name: "Luminaria de chão" },
  { image: require("./img/05-lightdecor.png"), name: "Luminaria decoração" },
  { image: require("./img/06-garlands.png"), name: "Luminaria jardim" },
];

class App extends Component {
  render() {
    return (
      <View style={{ flex: 1, padding: 16 }}>
        <View style={{ flexDirection: "row", alignItems: "center", justifyContent: "space-between" }}>
          <Text style={{ fontSize: 30, fontWeight: "bold" }}>Lighteria</Text>
          <View style={{ alignItems: "center", justifyContent: "center", borderRadius: 50, backgroundColor: "white", padding: 12, shadowColor: "black", shadowOffset: { width: 0, height: 2 }, shadowOpacity: 0.2, shadowRadius: 4 }}>
            <Feather name="shopping-bag" size={24} color="black" />
          </View>
        </View>

        <View style={{ flexDirection: "row", alignItems: "center", marginVertical: 8 }}>
          <View style={{ flex: 1, height: 1, backgroundColor: "gray" }} />
          <Text style={{ fontSize: 20, color: "gray", marginHorizontal: 8 }}>Categorias</Text>
          <View style={{ flex: 1, height: 1, backgroundColor: "gray" }} />
        </View>

        <FlatList
          data={data}
          numColumns={2}
          renderItem={({ item }) => (
            <View style={{ margin: 6, flex: 1, backgroundColor: "white", padding: 12, borderRadius: 8, shadowColor: "black", shadowOffset: { width: 0, height: 2 }, shadowOpacity: 0.2, shadowRadius: 4 }}>
              <Image source={item.image} style={{ height: 120, width: "100%", resizeMode: "contain" }} />
              <Text style={{ textAlign: "center", fontSize: 20, color: "gray" }}>{item.name}</Text>
            </View>
          )}
        />
      </View>
    );
  }
}

export default App;
