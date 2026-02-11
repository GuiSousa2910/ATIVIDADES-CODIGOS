import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { StyleSheet, Text, View, Image, Pressable } from 'react-native';

export default function App() {
  const [curtido, setCurtido] = useState(false);

  return (
    <View style={styles.container}>
      <Image 
        style={{width: 300, height: 300}}
        source={{uri:'https://sujeitoprogramador.com/wp-content/uploads/2020/02/Captura-de-Tela-2020-02-18-a%CC%80s-23.15.47-2048x1073.png'}}/>

      <Text 
        style={
          {color: "red", fontSize:50}
        }>Hello World!</Text>
      
      <Pressable style={styles.btn} onPress={() => {setCurtido(!curtido)}}>
        <Text> {curtido ? "curtido" : "nao curtido"} </Text>
      </Pressable>

      <StatusBar style="dark"/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  btn: {
    paddingHorizontal: 10,
    paddingVertical: 5,
    justifyContent: "center",
    alignItems:"center",
    color: "#fff",
    backgroundColor: "#af9494",
    borderRadius: 10
  }
});