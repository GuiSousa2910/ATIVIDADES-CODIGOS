export function Card() {
    return (
        <div className="border max-w-96 flex-col gap-2 rounded-md p-2">

            <div className="p-2">
                <span className="font-bold">16.04.2025</span>
            </div>

            <div>
                <h2 className="text-xl font-semibold">Tailwind é sensacional</h2>
                <p className="text-gray-600">Depois que eu usei Tailwind minha vida melhorou, Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsum necessitatibus minima deserunt repudiandae ea exercitationem, cumque eum debitis placeat cum! Esse odit nulla eveniet at a voluptatibus commodi adipisci modi!</p>
            </div>

            <div className="flex gap-2 items-center ">
                <img
                    src="https://tiermaker.com/images/chart/chart/naruto-classico--sem-figurantes--filosofisica--395963/capajpg.png"
                    alt="Imagem de perfil João Pedro"
                    className="w-10 h-10 rounded-full"
                />                <div className="tracking-wide">
                    <h3 className="font-semibold">João Pedro</h3>
                    <span className="text-sm">Engenheiro de Software</span>
                </div>
            </div>
        </div>
    );
} 