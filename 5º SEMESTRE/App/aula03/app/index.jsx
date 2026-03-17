import { View, Text, TouchableOpacity, StyleSheet } from 'react-native'
import { Link } from 'expo-router'

const exercises = [
    { title: 'Contador', href: '/contador' },
    { title: 'Tarefas Sprint', href: '/sprint' },
    { title: 'Mini Ecommerce', href: '/mini-ecommerce' },
]

export default function Home() {
    return (
       <View>
            <View style={styles.header}>
                <Text style={styles.title}>Exercícios</Text>
                <Text style={styles.subtitle}>Selecione um exercício</Text>
            </View>

            <View style={styles.exercisesContainer}>
                {exercises.map((exercise,index) => (
                    <Link key={index} href={exercise.href} asChild>
                        <TouchableOpacity style={styles.card}>
                            <Text style={styles.cardTitle}>{exercise.title}</Text>
                        </TouchableOpacity>
                    </Link>
                ))}
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#f5f5f5',
    },
    header: {
        padding: 24,
        paddingTop: 40,
        backgroundColor: '#007AFF',
    },
    title: {
        fontSize: 28,
        fontWeight: 'bold',
        color: '#fff',
        marginBottom: 8,
    },
    subtitle: {
        fontSize: 16,
        color: '#e0e0e0',
    },
    exercisesContainer: {
        padding: 16,
        gap: 12,
    },
    card: {
        backgroundColor: '#fff',
        padding: 16,
        borderRadius: 12,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.1,
        shadowRadius: 4,
        elevation: 3,
    },
    cardTitle: {
        fontSize: 16,
        fontWeight: '600',
        color: '#007AFF',
    },
})