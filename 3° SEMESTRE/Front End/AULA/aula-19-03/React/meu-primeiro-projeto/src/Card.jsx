function Card(props) {
    return (
        <div className="card">
            <h1>{props.titulo || "Default"}</h1>
            <p>{props.paragrafo}</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus nisi placeat nulla vitae eveniet officia provident quae et iure possimus, iusto voluptatem illo ratione expedita quis laborum voluptate harum accusamus.</p>
        </div>
    );
}

export default Card;