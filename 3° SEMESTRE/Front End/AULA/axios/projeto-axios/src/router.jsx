import { createBrowserRouter } from "react-router-dom";
import { Curtidas } from "./Curtidas";
import { Index } from "./Index";

export const route = createBrowserRouter([
    {
        path: "/curtidas",
        element: <Curtidas />,
        children:
            [
                {
                    path: "elemento",
                    element: <div>Element Primeiro</div>,
                },
                {
                    path: "produtos",
                    element: <div>Produtos</div>,
                }
            ]
    },
    {
        path: "/",
        element: <Index />,
    }
]);