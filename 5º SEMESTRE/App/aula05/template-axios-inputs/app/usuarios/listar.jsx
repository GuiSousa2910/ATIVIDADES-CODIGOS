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
            <Text>Lista de Usuarios</Text>
            <StatusBar style="auto" />
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
});