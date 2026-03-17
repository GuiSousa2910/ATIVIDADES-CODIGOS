import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import { useState } from 'react'
import dados from './tarefas.json'
import TaskCard from './_components/TaskCard'
import { useRouter } from 'expo-router'

export default function Sprint() {
  // Dica: este estado começa com os dados do JSON.
  // Pense em como atualizar apenas uma tarefa por vez, sem perder as outras.
  const [tarefas, setTarefas] = useState(dados.tarefas)


  function concluirTarefa(id) {
    // Dica: Use o id recebido para decidir qual tarefa precisa mudar o campo de conclusão.
  }

  function redirecionar(){
    // Use essa quantidade na rota de destino para montar o resumo na outra tela.
  }

  return (
    <View style={styles.container}>
      <Text style={styles.screenTitle}>Tarefas da Sprint</Text>

      <TouchableOpacity style={styles.button} onPress={()=>redirecionar()}>
        <Text style={{
            fontWeight:"bold",
            color:"white",
            textAlign:"center"
        }}>Finalizar Sprint</Text>
        </TouchableOpacity>

      {tarefas.map(tarefa => (
        <TaskCard
          key={tarefa.id}
          tarefa={tarefa}
          onConcluir={concluirTarefa}
        />
      ))}
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f4f6f8',
    padding: 16
  },
  screenTitle: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 16,
    color: '#1f2937'
  },
  button:{
    backgroundColor:"green",
    padding:10,
    borderRadius:7,
    marginBottom:20
  }
})