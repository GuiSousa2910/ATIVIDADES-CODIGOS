import { View, Text, StyleSheet } from 'react-native'
import { useLocalSearchParams } from 'expo-router'

export default function Resultado() {
  const { numeroSorteado, cliques } = useLocalSearchParams()

  return (
    <View style={styles.container}>
      <View style={styles.card}>
        <Text style={styles.titulo}>Parabens!</Text>
        <Text style={styles.texto}>Voce acertou o numero sorteado: {numeroSorteado}</Text>
        <Text style={styles.texto}>Quantidade de cliques: {cliques}</Text>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f5f5f5',
    padding: 20,
  },
  card: {
    backgroundColor: '#fff',
    width: '100%',
    borderRadius: 12,
    padding: 24,
    alignItems: 'center',
  },
  titulo: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#16a34a',
    marginBottom: 12,
  },
  texto: {
    fontSize: 18,
    color: '#374151',
    textAlign: 'center',
    marginBottom: 8,
  },
})
