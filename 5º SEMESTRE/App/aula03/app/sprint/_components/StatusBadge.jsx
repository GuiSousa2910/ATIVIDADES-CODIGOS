import { View, Text, StyleSheet } from 'react-native'

export  function StatusBadge({ concluido }) {
  return (
    <View
      style={[
        styles.badge,
        concluido ? styles.badgeDone : styles.badgePending
      ]}
    >
      <Text style={styles.badgeText}>
        {concluido ? 'Concluído' : 'Pendente'}
      </Text>
    </View>
  )
}

const styles = StyleSheet.create({
  badge: {
    paddingHorizontal: 10,
    paddingVertical: 4,
    borderRadius: 20
  },
  badgeDone: {
    backgroundColor: '#16a34a'
  },
  badgePending: {
    backgroundColor: '#f59e0b'
  },
  badgeText: {
    color: '#fff',
    fontSize: 12,
    fontWeight: '600'
  }
})