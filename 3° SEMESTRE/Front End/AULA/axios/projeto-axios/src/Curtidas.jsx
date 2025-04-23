import { Outlet } from "react-router-dom";

export function Curtidas(){
    return(
        <div>
            <h1>CURTIDAS</h1>
            <div>
                <Outlet />
            </div>
        </div>
    )
}