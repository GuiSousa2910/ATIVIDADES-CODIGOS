import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native'
import { useState } from 'react'
import { Slot } from 'expo-router'
import { Container } from './_components/Container'
import produtosDados from './produtos.json'
import { CarrinhoContext } from './_context/CarrinhoContext'

export default function Layout() {
    const [idDigitado, setIdDigitado] = useState('')
    const [carrinho, setCarrinho] = useState([])
    const [erro, setErro] = useState('')

    function adicionarAoCarrinho() {
        const id = Number(idDigitado)

        if (Number.isNaN(id) || id <= 0) {
            setErro('Digite um ID valido.')
            return
        }

        const produto = produtosDados.produtos.find(item => item.id === id)

        if (!produto) {
            setErro('Produto nao encontrado.')
            return
        }

        setCarrinho(valorAtual => [...valorAtual, produto])
        setErro('')
        setIdDigitado('')
    }

    return (
        <View style={styles.root}>
            <CarrinhoContext.Provider value={{ carrinho }}>
                <View style={styles.content}>
                    <Slot />
                </View>

                <Container>
                    <TextInput
                        style={styles.input}
                        keyboardType='numeric'
                        placeholder='Digite o ID do produto'
                        value={idDigitado}
                        onChangeText={setIdDigitado}
                    />

                    <TouchableOpacity style={styles.button} onPress={adicionarAoCarrinho}>
                        <Text style={styles.buttonText}>Adicionar ao Carrinho</Text>
                    </TouchableOpacity>

                    {erro ? <Text style={styles.errorText}>{erro}</Text> : null}

                    <Text style={styles.cartTitle}>Carrinho</Text>

                    {carrinho.length === 0 && <Text style={styles.emptyText}>Nenhum item adicionado.</Text>}

                    {carrinho.map((produto, index) => (
                        <View style={styles.item} key={`${produto.id}-${index}`}>
                            <Text style={styles.itemName}>{produto.nome}</Text>
                            <Text style={styles.itemPrice}>R$ {produto.preco.toFixed(2)}</Text>
                        </View>
                    ))}
                </Container>
            </CarrinhoContext.Provider>
        </View>
    )
}

const styles = StyleSheet.create({
    root: {
        flex: 1,
        marginTop: 50,
    },
    content: {
        flex: 1,
    },
    input: {
        borderWidth: 1,
        padding: 8,
        borderRadius: 4,
        borderColor: '#D1D5DB',
        backgroundColor: '#FFFFFF',
        marginBottom: 8,
    },
    button: {
        backgroundColor: '#007AFF',
        padding: 12,
        borderRadius: 4,
        marginBottom: 8,
    },
    buttonText: {
        color: '#FFF',
        fontWeight: 'bold',
        textAlign: 'center',
    },
    errorText: {
        color: '#DC2626',
        marginBottom: 8,
    },
    cartTitle: {
        fontSize: 18,
        fontWeight: 'bold',
        color: '#111827',
        marginBottom: 8,
    },
    emptyText: {
        color: '#6B7280',
        marginBottom: 8,
    },
    item: {
        backgroundColor: '#FFFFFF',
        borderRadius: 8,
        padding: 10,
        marginBottom: 8,
        borderWidth: 1,
        borderColor: '#E5E7EB',
    },
    itemName: {
        color: '#111827',
        fontSize: 15,
        fontWeight: '600',
    },
    itemPrice: {
        color: '#16A34A',
        marginTop: 4,
        fontWeight: '600',
    },
})