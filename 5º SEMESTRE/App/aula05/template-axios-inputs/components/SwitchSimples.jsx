import { Switch } from 'react-native';

export default function SwitchSimples({ isEnabled, setEnabled }) {
    const toggleSwitch = () => setEnabled(previousState => !previousState);

    return (
        <Switch
            trackColor={{ false: "#2bff00", true: "#fa0000" }}
            thumbColor={isEnabled ? "#f5dd4b" : "#ff00ff"}
            onValueChange={toggleSwitch}
            value={isEnabled}
        />
    );
}