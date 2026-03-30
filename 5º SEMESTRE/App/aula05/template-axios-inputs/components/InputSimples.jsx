import React from 'react';
import { TextInput, StyleSheet } from 'react-native';

const InputSimples = ({ text, setText, placeholder }) => {

    return (
        <TextInput
            style={styles.input}
            placeholder={placeholder}
            value={text}
            onChangeText={setText}
        />
    );
};

export default InputSimples;

const styles = StyleSheet.create({
    input: {
        height: 50,
        borderWidth: 1,
        borderColor: '#ccc',
        paddingHorizontal: 10,
        borderRadius: 8,
    },
});