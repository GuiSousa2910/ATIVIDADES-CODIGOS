import { View, StyleSheet } from 'react-native'
// Dica: aqui é um bom lugar para importar o JSON de produtos
import { ProductCard } from './_components/ProductCard'

export default function Produtos() {
  // Dica: carregue os produtos do JSON (local) e guarde em uma constante ou estado.
  // Cada item deve ter pelo menos: id, nome, preço e descrição.

  return (
    <View style={styles.container}>
      {/* Dica: em vez dessa lista fixa, renderize aqui os produtos vindos do JSON usando map */}
      {['produto 1', 'produto 2', 'produto 3'].map((element, index) => (
        <ProductCard
          key={index}
          element={element}
          // Dica: a função de redirecionamento deve usar o router para ir para a tela de detalhes,
          // enviando o id (e/ou os dados do produto) por params
          onRedirect={() => { /* Implemente a navegação para a tela de detalhes aqui */ }}
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
