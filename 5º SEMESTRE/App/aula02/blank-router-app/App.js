import { StatusBar } from 'expo-status-bar';
import { use, useState } from 'react';
import { StyleSheet, Text, View, Pressable, Image } from 'react-native';

export default function App() {
  const [fechado, setFechado] = useState(true)

  return (
    <View style={styles.container}>
      <Pressable onPress={() => setFechado(!fechado)}>
        <Image 
          style={{width: 300, height: 300}}
          source={{
            uri: fechado ? "https://thumbs.dreamstime.com/b/porta-fechada-branca-46402286.jpg" : "https://static.vecteezy.com/system/resources/previews/018/754/240/non_2x/white-6-panel-open-door-isolated-png.png"
          }}
        />
      </Pressable>
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
});
