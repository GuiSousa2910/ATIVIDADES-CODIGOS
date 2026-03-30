import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Pressable } from 'react-native';
import React, { useState } from 'react';
import InputSimples from '../../components/InputSimples';
import PickerSimples from '../../components/PickerSimples';
import CheckboxSimples from '../../components/CheckboxSimples';
import SwitchSimples from '../../components/SwitchSimples';
import api from '../../api';

export default function Criar() {
    const [nome, setNome] = useState('JP');
    const [email, setEmail] = useState('jp@gmail.com');
    const [tipo, setTipo] = useState('comum');
    const [ativo, setAtivo] = useState(false);
    const [habilitado, setHabilitado] = useState(false);

    async function criarUser() {
        const novoUser = {
            nome,
            email,
            tipo,
            ativo
        }
        const resposta = await api.post("/users", novoUser);
        console.log(resposta);
    }

    return (
        <View style={styles.container}>
            <View>
                <Text>Nome: {nome}</Text>
                <InputSimples text={nome} setText={setNome} placeholder="Digite seu nome" />
            </View>
            <View>
                <Text>Email: {email}</Text>
                <InputSimples text={email} setText={setEmail} placeholder="Digite seu email" />
            </View>
            <View>
                <Text>Tipo: {tipo}</Text>
                <PickerSimples selectedType={tipo} setSelectedType={setTipo} />
            </View>
            <View>
                <Text>Usuário Ativo: {ativo ? 'Sim' : 'Não'}</Text>
                <CheckboxSimples isChecked={ativo} setChecked={setAtivo} />
            </View>
            <View>
                <Text>Usuário Habilitado: {habilitado ? 'Sim' : 'Não'}</Text>
                <SwitchSimples isEnabled={habilitado} setEnabled={setHabilitado} />
            </View>

            <Pressable style={styles.btn} onPress={criarUser}>
                <Text>Criar Usuário</Text>
            </Pressable>

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
    btn: {
        backgroundColor: '#baffff',
        padding: 10,
    }
});''