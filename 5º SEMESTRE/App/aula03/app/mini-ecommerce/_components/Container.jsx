import { View, Text } from 'react-native'

export function Container({ children }) {
  return (
    <View style={{
      paddingHorizontal: 16,
      paddingVertical: 12,
      backgroundColor: '#F3F4F6',
      borderTopWidth: 1,
      borderTopColor: '#E5E7EB',
    }}>
      <View style={{
        paddingHorizontal: 16,
        paddingVertical: 12,
        backgroundColor: '#DBEAFE',
        borderRadius: 10,
        marginBottom: 10,
      }}>
        <Text style={{
          fontSize: 20,
          fontWeight: 'bold',
          color: '#1E3A8A'
        }}>Carrinho</Text>
      </View>

      <View style={{ gap: 8 }}>{children}</View>
    </View>
  )
}