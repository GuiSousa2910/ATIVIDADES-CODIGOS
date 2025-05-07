import e from "express"
import { autenticacao } from "../routes/autenticacao.mjs";
import { usuarios } from "../routes/usuarios.mjs";
import { autenticacaoService } from "../services/autenticacaoService.mjs";
import 'dotenv/config'
import { postagens } from "../routes/postagem.mjs";
import cors from 'cors'
import { comentarios } from "../routes/comentarios.mjs";

const app = () => {
  const app = e();
  const PORT = 8080;
  app.use(e.json());
  app.use(cors())
  app.set('port', PORT);
  app.use(autenticacaoService.verifyToken);
  app.use(autenticacaoService.descriptografarPayload)
  app.use("/api/usuarios", autenticacao);
  app.use("/api/usuarios",usuarios)
  app.use("/api/postagens",postagens)
  app.use("/api/postagens/:idPostagem/comentarios",comentarios)

  return app;
};

export const server = app();

