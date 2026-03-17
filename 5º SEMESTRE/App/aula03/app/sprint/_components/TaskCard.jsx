import { View, Text, StyleSheet } from 'react-native'
import {StatusBadge} from './StatusBadge'
import {ConcluirButton} from './ConcluirButton'

export default function TaskCard({ tarefa, onConcluir }) {
  return (
    <View style={[styles.card, tarefa.concluido ? styles.cardDone : styles.cardPending]}>
      <View style={styles.header}>
        <Text style={styles.title}>{tarefa.name}</Text>
        <StatusBadge concluido={tarefa.concluido} />
      </View>

      <Text style={styles.description}>{tarefa.descricao}</Text>

      <ConcluirButton
        label={tarefa.concluido ? 'Desmarcar Tarefa' : 'Concluir Tarefa'}
        onPress={() => onConcluir(tarefa.id)}
      />
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
  cardDone: {
    borderWidth: 1,
    borderColor: '#16a34a',
  },
  cardPending: {
    borderWidth: 1,
    borderColor: '#f59e0b',
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