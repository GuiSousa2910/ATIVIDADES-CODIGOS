import { Carousel } from "./components/Carrosel"
import { Button } from "../../componentes/Button"
import { ROUTERS } from "../../constantes/routers"
import { cards } from "./data/data"

export const Home = () => (
  <main className="grid grid-cols-1 grid-rows-1 bg-ft-background">
    <section className="bg-[url(/images/banner.png)] h-full w-full text-white p-24 bg-cover col-span-3">
      <div className="flex flex-col gap-[34px]">
        <h1 className="font-bold text-5xl ">
          Conecte-se com a <span className="text-ft-secondary">comunidade</span>
        </h1>
        <p className="text-2xl/8">
          <span className="text-ft-secondary">Descubra </span> a plataforma definitiva para <br /> desenvolvedores
          trocarem <span className="text-ft-secondary">ideias</span>, resolverem <br />{' '}
          <span className="text-ft-secondary">desafios</span> e crescerem{' '}
          <span className="text-ft-secondary">juntos</span>.
        </p>
        <div className="w-1/2">
          <Button variant="ghost" redirect={ROUTERS.SIGNUP}>
            CRIAR UMA CONTA
          </Button>
        </div>
      </div>
    </section>
    <section className="h-full w-full p-24 bg-cover col-span-3">
      <div className="flex flex-col gap-[23px]">
        <p className="uppercase text-sm font-bold text-ft-secondary">Conheça o ForumTech</p>
        <h1 className="font-bold text-4xl">
          Estamos aqui para ajudar você, <span className="text-ft-secondary font-bold">Dev!</span>
        </h1>
        <p className="text-2xl/8 text-ft-gray-white">
          Somos um fórum dedicado a desenvolvedores de todos os níveis. Entendemos os desafios enfrentados no dia a dia
          da programação e criamos um espaço para compartilhar conhecimento, trocar experiências e encontrar soluções
          para problemas técnicos. Aqui, você pode discutir tecnologias, aprimorar suas habilidades e conectar-se com
          uma comunidade que impulsiona a inovação no desenvolvimento de software
        </p>
      </div>
    </section>
    <section className="h-full w-full flex justify-center bg-ft-secondary p-24 bg-cover col-span-3">
      <div className="flex flex-col w-9/12 text-center gap-[23px]">
        <h1 className="font-bold text-5xl text-white">Conectando desenvolvedores</h1>
        <p className="text-2xl/8 text-white">
          Nosso fórum reúne desenvolvedores e iniciativas que impactam positivamente o mundo da tecnologia. Valorizamos
          o compartilhamento de conhecimento e a colaboração, conectando profissionais que impulsionam inovação e boas
          práticas no desenvolvimento de software. Aqui, você encontra discussões com membros de grandes comunidades e
          empresas de referência no setor.
        </p>
      </div>
    </section>
    <section className="h-full w-full p-24 bg-cover col-span-3">
      <div className="flex flex-col gap-[23px]">
        <p className="uppercase text-sm font-bold text-ft-secondary">Encontre sua solução</p>
        <h1 className="font-bold text-4xl">
          Um pouco mais sobre nossas <span className="text-ft-secondary font-bold"> soluções!</span>
        </h1>
        <Carousel cards={cards} />
      </div>
    </section>
  </main>
)
