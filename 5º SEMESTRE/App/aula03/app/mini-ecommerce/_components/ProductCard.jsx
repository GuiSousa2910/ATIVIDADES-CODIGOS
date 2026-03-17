import { Pressable, StyleSheet, Text, View } from "react-native";

export function ProductCard({ element, onRedirect }) {
  return (
    <View style={styles.card}>
      <Text style={styles.nome}>{element.nome}</Text>
      <Text style={styles.preco}>R$ {element.preco.toFixed(2)}</Text>
      <Pressable style={styles.button} onPress={onRedirect}>
        <Text style={styles.buttonText}>Ver mais</Text>
      </Pressable>
    </View>
  )
}

const styles = StyleSheet.create({
  card: {
    backgroundColor: '#fff',
    padding: 16,
    marginBottom: 12,
    borderRadius: 8,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  nome: {
    fontSize: 18,
    fontWeight: '600',
    marginBottom: 4,
    color: '#333',
  },
  preco: {
    fontSize: 16,
    fontWeight: '600',
    color: '#16A34A',
    marginBottom: 12,
  },
  button: {
    backgroundColor: '#007AFF',
    paddingVertical: 10,
    paddingHorizontal: 16,
    borderRadius: 6,
    alignItems: 'center',
  },
  buttonText: {
    color: '#fff',
    fontWeight: '600',
    fontSize: 14,
  },
})