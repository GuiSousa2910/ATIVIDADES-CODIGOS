
import { useEffect } from "react";
import { ENDPOINTS } from "../../constantes/endpoints";
import { api } from "../../http/axios-instance";
import { Card } from "../../componentes/Card";

export const Publicacoes = () => {
  useEffect(() => {
    api.get(ENDPOINTS.POSTAGENS).then(resposta => console.log(resposta));
  }, []);

  return (
    <section className="overflow-y-auto max-h-[100vh] flex-1 bg-slate-300 scrollbar-hide">
      <div className="w-10/12 mx-auto ">
        <Card />
      </div>
    </section>
  );
};
