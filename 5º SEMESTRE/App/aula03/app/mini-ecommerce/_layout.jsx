import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native'
import { Slot } from 'expo-router'
import { Container } from './_components/Container'

export default function Layout() {
    // Dica importante: este layout envolve as telas de lista e detalhes.
    // Pense em como ler o ID digitado, validar no JSON e adicionar o produto (com quantidade) a uma lista de itens no carrinho.

    return (
        <View style={styles.root}>
            {/* <Container></Container> */}
            <Slot />
        </View>
    )
}

const styles = StyleSheet.create({
    root: {
        flex: 1,
        marginTop: 50,
    },
    input: {
        borderWidth: 1,
        padding: 8,
        borderRadius: 4,
    },
    button: {
        backgroundColor: '#007AFF',
        padding: 12,
        borderRadius: 4,
    },
    buttonText: {
        color: '#FFF',
        fontWeight: 'bold',
        textAlign: 'center',
    },
})