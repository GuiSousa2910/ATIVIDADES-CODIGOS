import { IoMdMore } from "react-icons/io";
import { CiChat1 } from "react-icons/ci";

export function Card({postagem}) {
    return (
        <div className="px-4 py-7 bg-white rounded-md max-w-[550px] flex flex-col gap-4">
            <div className="flex justify-between items-center">

                <div className="flex gap-2">

                    <div>
                        <img src="/images/banner.png" className="w-10 h-10 rounded-full object-cover" />
                    </div>
                    <div className="flex flex-col justify-center">
                        <span className="text-[13px] font-medium">{postagem.user.nome}</span>
                        <span className="text-[10px] text-ft-gray-white">5H atrás</span>
                    </div>
                </div>
                <div>
                    <IoMdMore size={"20px"} />
                </div>
            </div>
            <div>
                <h3 className="text-sm font-semibold mb-1">{postagem.titulo}</h3>
                <p className="text-sm font-light">{postagem.comentario}</p>

            </div>
            <div className="flex gap-1">
                <CiChat1 />
                <span className="text-xs text-ft-gray-white">15</span>
            </div>
        </div>
    );
}
