import { View, Text, StyleSheet } from 'react-native';
// Dica: esta tela deve receber informações do produto selecionado
// (por id na rota e/ou por params) e exibir os detalhes completos.

export default function Detalhes() {
    // Com o id em mãos, você pode localizar o produto no JSON e tratar o caso em que não for encontrado.

    return (
        <View style={styles.container}>
            <View style={styles.conteudo}>
                {/* Dica: substitua os textos fixos pelos dados reais do produto */}
                <Text style={styles.titulo}>Nome do produto</Text>

                <Text style={styles.preco}>Preco do produto</Text>

                <Text style={styles.label}>Descrição</Text>
                <Text style={styles.descricao}>Descrição do produto</Text>
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