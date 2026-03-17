import { View, Text } from 'react-native'

export function Container({ children }) {
  return (
    <View style={{ flex: 1 }}>
      <View style={{
        flex: 0.7
      }}>
        <View style={{
          paddingHorizontal: 16,
          paddingVertical: 16,
          backgroundColor: '#007AFF',
          borderBottomWidth: 1,
          borderBottomColor: '#E5E5EA'
        }}>
          <Text style={{
            fontSize: 24,
            fontWeight: 'bold',
            color: '#FFFFFF'
          }}>🛒 Carrinho</Text>
        </View>

        <View style={{ padding: 16, gap: 8 }}>{children}</View>
      </View>
    </View>
  )
}