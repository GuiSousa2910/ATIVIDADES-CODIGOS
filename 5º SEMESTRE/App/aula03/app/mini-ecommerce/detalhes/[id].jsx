import { View, Text, StyleSheet } from 'react-native';
import { useLocalSearchParams } from 'expo-router'
import dadosProdutos from '../produtos.json'

export default function Detalhes() {
    const { id } = useLocalSearchParams()
    const produto = dadosProdutos.produtos.find(item => item.id === Number(id))

    if (!produto) {
        return (
            <View style={styles.container}>
                <Text style={styles.erro}>Produto nao encontrado.</Text>
            </View>
        )
    }

    return (
        <View style={styles.container}>
            <View style={styles.conteudo}>
                <Text style={styles.titulo}>{produto.nome}</Text>

                <Text style={styles.preco}>R$ {produto.preco.toFixed(2)}</Text>

                <Text style={styles.label}>Descrição</Text>
                <Text style={styles.descricao}>{produto.descricao}</Text>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#f5f5f5',
        flex: 0.7
    },
    conteudo: {
        padding: 20,
    },
    titulo: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 10,
        color: '#333',
    },
    preco: {
        fontSize: 22,
        fontWeight: 'bold',
        color: '#27ae60',
        marginBottom: 20,
    },
    label: {
        fontSize: 14,
        fontWeight: '600',
        color: '#666',
        marginTop: 15,
        marginBottom: 5,
    },
    descricao: {
        fontSize: 16,
        color: '#555',
        lineHeight: 24,
    },
    texto: {
        fontSize: 16,
        color: '#555',
    },
    erro: {
        fontSize: 16,
        color: '#e74c3c',
        textAlign: 'center',
        marginTop: 20,
    },
});