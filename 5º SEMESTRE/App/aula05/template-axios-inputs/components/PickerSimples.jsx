import { Picker } from '@react-native-picker/picker';

const PickerSimples = ( { selectedType, setSelectedType } ) => {
    return (
        <Picker
            
            selectedValue={selectedType}
            onValueChange={setSelectedType}
        >
            <Picker.Item label="Comum" value="comum" />
            <Picker.Item label="Administrador" value="admin" />
        </Picker>
    );
};

export default PickerSimples;