import { Pressable, StyleSheet, Text, View } from "react-native";

// Dica: o "element" aqui deve representar um produto completo
// (ex.: { id, nome, preco, descricao, ... })
export function ProductCard({ element, onRedirect }) {
  return (
    <View style={styles.card}>
      {/* Dica: aqui você pode exibir um resumo do produto (nome e talvez o preço) */}
      <Text style={styles.nome}>{element.nome}</Text>
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
    marginBottom: 12,
    color: '#333',
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