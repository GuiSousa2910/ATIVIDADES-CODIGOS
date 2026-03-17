import { View, Text, StyleSheet } from 'react-native'
import {StatusBadge} from './StatusBadge'
import {ConcluirButton} from './ConcluirButton'

export default function TaskCard({ tarefa, onConcluir }) {
  return (
    <View style={styles.card}>
      <View style={styles.header}>
        <Text style={styles.title}>{tarefa.name}</Text>
        <StatusBadge concluido={tarefa.concluido} />
      </View>

      <Text style={styles.description}>{tarefa.descricao}</Text>

      {!tarefa.concluido && (
        <ConcluirButton onPress={() => onConcluir(tarefa.id)} />
      )}
    </View>
  )
}

const styles = StyleSheet.create({
  card: {
    backgroundColor: '#ffffff',
    padding: 16,
    borderRadius: 12,
    marginBottom: 12,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center'
  },
  title: {
    fontSize: 16,
    fontWeight: '600',
    color: '#111827',
    flex: 1,
    marginRight: 8
  },
  description: {
    marginTop: 8,
    fontSize: 14,
    color: '#4b5563'
  }
})