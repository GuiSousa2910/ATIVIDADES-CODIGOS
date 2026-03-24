import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Pressable } from 'react-native';
import { useRouter } from 'expo-router';

export default function Home() {
    const router = useRouter();

    return (
        <View style={styles.container}>
            <Text>Pagina Inicial</Text>
            <Pressable onPress={() => router.push('/usuarios/listar')}>
                <Text>Listar Usuários</Text>
            </Pressable>

            <Pressable onPress={() => router.push('/usuarios/criar')}>
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
});