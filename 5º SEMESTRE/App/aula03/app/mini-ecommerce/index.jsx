import { View, StyleSheet } from 'react-native'
import { useRouter } from 'expo-router'
import dadosProdutos from './produtos.json'
import { ProductCard } from './_components/ProductCard'

export default function Produtos() {
  const router = useRouter()

  return (
    <View style={styles.container}>
      {dadosProdutos.produtos.map(element => (
        <ProductCard
          key={element.id}
          element={element}
          onRedirect={() => {
            router.push({
              pathname: '/mini-ecommerce/detalhes/[id]',
              params: { id: String(element.id) },
            })
          }}
        />
      ))}
    </View>
  )
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: '#f5f5f5',
  }
})
