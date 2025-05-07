import { postagemRepository } from "../repository/postagemRepository.mjs";
import { usuarioRespository } from "../repository/usuarioRespository.mjs";

export const PostagensService = () => {

  const mapperPostagem = (postagem) => {

    const usuario = usuarioRespository.findByUserId(postagem.usuarioId)

    delete postagem.usuarioId;
    
    const postagemResponse = {
      ...postagem,
      usuario: {
        nome: usuario.nome,
        email: usuario.email
      }
    }

    return postagemResponse;

  }

  const getPostagens = async (req, res) => {
    try {
      const postagens = await postagemRepository.findAll();
    
      if (postagens.length <= 0) return res.status(204).send();
 
      const postagensResponse = postagens.map(postagem => mapperPostagem(postagem))
 
      return res.status(200).json(postagensResponse);
    } catch (error) {
      console.log(error)
      return res.status(500).json({ error: "Erro ao buscar postagens." });
    }
  };
  const getPostagensPorId = async (req, res) => {
    const { id } = req.params;

    if (!id) {
      return res.status(400).json({ error: "ID da postagem não fornecido." });
    }

    try {
      const postagem = await postagemRepository.findById(id);

      if (!postagem) {
        return res.status(404).json({ error: "Postagem não encontrada." });
      }
      const postagemResponse = mapperPostagem(postagem);

      return res.status(200).json(postagemResponse);
    } catch (error) {
      return res.status(500).json({ error: "Erro ao buscar postagem." });
    }
  };



  const postPostagens = async (req, res) => {
    const postagemData = req.body;

    const usuarioId = req.usuarioId;

    const novaPostagem = {
      titulo: postagemData.titulo,
      conteudo: postagemData.conteudo,
      usuarioId,
      criadoEm: new Date(),
    };

    try {
      const postagemCriada = await postagemRepository.save(novaPostagem);
      const postagemResponse = mapperPostagem(postagemCriada)
      return res.status(201).json(postagemResponse);
    } catch (error) {
      console.log(error)
      return res.status(500).json({ error: "Erro ao criar postagem." });
    }
  };

  const updatePostagens = async (req, res) => {
    const { id } = req.params;
    const postagemData = req.body;

    try {
      const postagemExistente = await postagemRepository.findById(id);
      if (!postagemExistente) {
        return res.status(404).json({ error: "Postagem não encontrada." });
      }

      const postagemAtualizada = {
        titulo: postagemData.titulo || postagemExistente.titulo,
        conteudo: postagemData.conteudo || postagemExistente.conteudo,
        criadoEm: postagemExistente.criadoEm,
        atualizadoEm: new Date(),
      };

      const postagemAtualizadaResult = await postagemRepository.update(id, postagemAtualizada);

      const postagemResponse = mapperPostagem(postagemAtualizadaResult)
      return res.status(200).json(postagemResponse);
    } catch (error) {
      return res.status(500).json({ error: "Erro ao atualizar postagem." });
    }
  };

  const deletePostagens = async (req, res) => {
    const { id } = req.params;

    if (!id) {
      return res.status(400).json({ error: "ID da postagem não fornecido." });
    }

    try {
      const postagemExistente = await postagemRepository.existsById(id);
      if (!postagemExistente) {
        return res.status(404).json({ error: "Postagem não encontrada." });
      }

      await postagemRepository.deleteById(id);
      return res.status(204).send();
    } catch (error) {
      return res.status(500).json({ error: "Erro ao deletar postagem." });
    }
  };

  return {
    getPostagens,
    postPostagens,
    updatePostagens,
    deletePostagens,
    getPostagensPorId
  };
};

export const postagemService = PostagensService();