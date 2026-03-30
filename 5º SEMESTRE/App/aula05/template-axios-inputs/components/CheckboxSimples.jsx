import Checkbox from 'expo-checkbox';

export default function CheckboxSimples({ isChecked, setChecked }) {
    return (
        <Checkbox
            value={isChecked}
            onValueChange={setChecked}
            color={isChecked ? '#4630EB' : undefined}
        />
    );
}