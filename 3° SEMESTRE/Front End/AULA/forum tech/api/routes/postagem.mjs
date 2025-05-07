import { Router } from "express";
import { postagemService } from "../services/postagensService.mjs";
import { validarCampos } from "../middlewares/validarCampos.mjs";
import { postagemCreateValidations } from "./validations/postagem/postagemCreateValidations.mjs";
import { postagemUpdateValidations } from "./validations/postagem/PostagemUpdateValidations.mjs";

const postagemRouter = Router();

postagemRouter.get("", postagemService.getPostagens);
postagemRouter.get("/:id", postagemService.getPostagensPorId);
postagemRouter.post("", postagemCreateValidations, validarCampos,postagemService.postPostagens);
postagemRouter.patch("/:id", postagemUpdateValidations,validarCampos,postagemService.updatePostagens);
postagemRouter.delete("/:id", postagemService.deletePostagens);

export const postagens = postagemRouter;