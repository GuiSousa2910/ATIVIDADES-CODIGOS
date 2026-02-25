import { View, Pressable, Text } from "react-native"
import { useRouter } from "expo-router";

export default function Subpasta(){
    const router = useRouter()
    return(
        <View style={{
            backgroundColor: "green", 
            flex: 1, 
            alignItems: "center",
            justifyContent: "center"
            }}>
            <Text style={{color: "black", fontWeight: "bold"}}>Página Subpagina</Text>
            <Pressable
                style={{
                    paddingVertical: 5,
                    paddingHorizontal: 10,
                    backgroundColor: "red"
                }}
                onPress={() => {router.back()}}
                ><Text style={{color: "black", fontWeight: "bold"}}>Ir para a home</Text>
            </Pressable>
        </View>
    )
}