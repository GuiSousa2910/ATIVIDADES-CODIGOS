import "./App.css";
import Card from "./Card";

function App() {

  return (
    <>
      <Card titulo={""} paragrafo={"Ele é legal"}/>
      <Card titulo={"Pedro"} paragrafo={"Ele é chato"}/>
      <Card titulo={"Gui"} paragrafo={"Ele é doido"}/>
    </>
  );
}

export default App;