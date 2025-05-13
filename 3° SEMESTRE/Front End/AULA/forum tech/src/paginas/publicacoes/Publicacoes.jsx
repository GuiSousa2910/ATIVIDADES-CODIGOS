
import { useEffect } from "react";
import { ENDPOINTS } from "../../constantes/endpoints";
import { api } from "../../http/axios-instance";
import { Card } from "../../componentes/Card";

export const Publicacoes = () => {

  const [postagens, setPostagens] = useState([]);

  useEffect(() => {
    api.get(ENDPOINTS.POSTAGENS).
      then(resposta =>
        setPostagens(Array.isArray(resposta.data) ? resposta.data : [resposta.data])
      ).catch(erro => {
        console.error("Erro ao buscar postagens:", erro);
        alert("Erro ao buscar postagens");
      });
  }, []);

  return (
    <section className="overflow-y-auto max-h-[100vh] flex-1 bg-slate-300 scrollbar-hide">
      <div className="w-10/12 mx-auto">
        {postagens.map(post => (
          <Card key={post.id} postagem={post} />
        ))}
      </div>
    </section>
  );
};
