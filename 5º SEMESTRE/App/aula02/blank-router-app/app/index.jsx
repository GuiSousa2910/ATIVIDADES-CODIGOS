import { useRouter } from "expo-router";
import { View, Text, Pressable } from "react-native";

export default function Home (){
    const router = useRouter()
    return(
        <View style={{backgroundColor: "blue", flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{color: "white", fontWeight: "bold"}}>Página inicial</Text>
            <Pressable
                style={{
                    paddingVertical: 5,
                    paddingHorizontal: 10,
                    backgroundColor: "white"
                }}
                onPress={() => {router.push('/perfil')}}
                ><Text style={{color: "black", fontWeight: "bold"}}>Ir para o perfil</Text>
            </Pressable>
            <Pressable
                style={{
                    paddingVertical: 5,
                    paddingHorizontal: 10,
                    backgroundColor: "white"
                }}
                onPress={() => {router.push('/subpasta/subtela')}}
                ><Text style={{color: "black", fontWeight: "bold"}}>Ir para a subtela</Text>
            </Pressable>
        </View>
    )
}