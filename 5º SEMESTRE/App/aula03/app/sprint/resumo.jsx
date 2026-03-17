import { View, Text, StyleSheet } from 'react-native'
import { useLocalSearchParams } from 'expo-router'

export default function ResumoSprint() {
  const { tarefas } = useLocalSearchParams()
  const listaTarefas = tarefas ? JSON.parse(tarefas) : []

  const total = listaTarefas.length
  const concluidas = listaTarefas.filter(tarefa => tarefa.concluido).length
  const pendentes = total - concluidas
  const percentual = total > 0 ? Math.round((concluidas / total) * 100) : 0

  let mensagem = 'Bom progresso, mas ainda pode melhorar.'

  if (percentual === 100) {
    mensagem = 'Sprint concluida com sucesso!'
  } else if (percentual < 50) {
    mensagem = 'Atencao! Muitas tarefas ficaram pendentes.'
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Resumo da Sprint</Text>

      <View style={styles.card}>
        <Text style={styles.line}>Total de tarefas: {total}</Text>
        <Text style={styles.line}>Tarefas finalizadas: {concluidas}</Text>
        <Text style={styles.line}>Tarefas pendentes: {pendentes}</Text>
        <Text style={styles.line}>{concluidas} de {total} tarefas concluidas</Text>
        <Text style={styles.line}>{percentual}% da sprint finalizada</Text>
      </View>

      <Text style={styles.message}>{mensagem}</Text>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f4f6f8',
    padding: 16,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#111827',
    marginBottom: 12,
  },
  card: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 16,
    marginBottom: 16,
    shadowColor: '#000',
    shadowOpacity: 0.08,
    shadowRadius: 4,
    elevation: 2,
  },
  line: {
    fontSize: 16,
    color: '#374151',
    marginBottom: 8,
  },
  message: {
    fontSize: 18,
    fontWeight: '600',
    color: '#2563eb',
  },
})
