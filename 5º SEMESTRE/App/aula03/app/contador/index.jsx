import { View, Text, Pressable, StyleSheet } from 'react-native'

export default function Contadora() {
    // Dica: Use o useEffect para sortear os numeros logo após a tela aparecer
    // Dica: Use o useEffect para observar quando o contadora foi igual o numero sorteado
    
    return (
        <View style={styles.container}>
            <View style={styles.card}>
                <Text style={styles.label}>Contador</Text>
                {/* Dica: este valor deve vir de um estado que começa em 0 */}
                <Text style={styles.contador}>0</Text>

                <Pressable
                    style={styles.button}
                    // Dica: ao pressionar, incremente o contador e atualize o número de cliques
                >
                    <Text style={styles.buttonText}>Contar</Text>
                </Pressable>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f5f5f5',
    },
    card: {
        backgroundColor: '#fff',
        padding: 30,
        borderRadius: 15,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.25,
        shadowRadius: 4,
        elevation: 5,
        width: '80%',
    },
    label: {
        fontSize: 16,
        color: '#666',
        marginBottom: 8,
        textAlign: 'center',
    },
    numeroSorteado: {
        fontSize: 48,
        fontWeight: 'bold',
        color: '#2196F3',
        textAlign: 'center',
        marginBottom: 30,
    },
    contador: {
        fontSize: 48,
        fontWeight: 'bold',
        color: '#4CAF50',
        textAlign: 'center',
        marginBottom: 30,
    },
    button: {
        backgroundColor: '#2196F3',
        paddingVertical: 15,
        borderRadius: 10,
        marginTop: 20,
    },
    buttonText: {
        color: '#fff',
        fontSize: 18,
        fontWeight: 'bold',
        textAlign: 'center',
    },
})