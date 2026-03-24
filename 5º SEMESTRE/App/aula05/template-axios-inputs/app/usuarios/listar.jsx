import { StatusBar } from 'expo-status-bar';
import { useEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import api from '../../api';

export default function Listar() {

    const [users, setUsers] = useState([]);

    async function buscarUsuarios() {
        const response = await api.get("/users");
        console.log(response);
        setUsers(response.data);
    }

    useEffect(() => {
        buscarUsuarios();
    }, [])

    return (
        <View style={styles.container}>
            {users.map((usuario) => (
                (<View key={usuario.id} style={styles.card}>
                    <Text>Nome: {usuario.nome}</Text>
                    <Text>Email: {usuario.email}</Text>
                    <Text>Cargo: {usuario.tipo}</Text>
                    <Text>Ativo: {usuario.ativo ? 'Sim' : 'Não'}</Text>
                </View>)
            ))}

        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    card: {
        backgroundColor: '#baffff',
        padding: 10,
        marginBottom: 10,
        borderRadius: 5,
    }
});