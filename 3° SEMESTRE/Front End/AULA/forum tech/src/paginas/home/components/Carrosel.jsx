import { Icon } from '@iconify/react'
import { useState } from 'react'
import { cn } from '../../../uteis/cn'


export const Carousel = ({ cards }) => {
  const [startIndex, setStartIndex] = useState(0)
  const visibleCards = 4

  const nextSlide = () => {
    if (startIndex + visibleCards < cards.length) {
      setStartIndex(startIndex + 1)
    }
  }

  const prevSlide = () => {
    if (startIndex > 0) {
      setStartIndex(startIndex - 1)
    }
  }

  return (
    <>
      <div className="relative flex items-center">
        <button
          type="button"
          disabled={startIndex === 0}
          onClick={prevSlide}
          className={cn(
            'absolute flex items-center justify-center w-[3vw] h-[5vh] text-ft-secondary cursor-pointer left-0 z-10 -translate-x-1/2 p-2 text-2xl rounded-full shadow-md',
            startIndex === 0 ? 'bg-ft-gray-dark/45' : 'bg-ft-gray-dark'
          )}>
          <Icon icon={'weui:arrow-filled'} className="-scale-x-100" />
        </button>
        <div className="flex flex-row gap-4">
          {cards.slice(startIndex, startIndex + visibleCards).map((solution, index) => (
            <div key={index} className="flex flex-col gap-4">
              <div className="flex gap-4">
                <div className="bg-gradient-to-r from-ft-primary to-ft-secondary h-[316px] p-4 flex flex-col items-center justify-center gap-8 border rounded-lg text-white text-center">
                  <img src={solution.image} alt="teste" />
                  <p className="font-bold text-lg">{solution.title}</p>
                  <p className="text-sm">{solution.description}</p>
                </div>
              </div>
            </div>
          ))}
        </div>
        <button
          type="button"
          disabled={startIndex + visibleCards >= cards.length}
          onClick={nextSlide}
          className={cn(
            'absolute flex items-center justify-center w-[3vw] h-[5vh] text-ft-secondary cursor-pointer right-0 z-10 translate-x-1/2 text-2xl bg-white p-2 rounded-full shadow-md',
            startIndex + visibleCards >= cards.length ? 'bg-ft-gray-dark/45' : 'bg-ft-gray-dark'
          )}>
          <Icon icon={'weui:arrow-filled'} />
        </button>
      </div>
    </>
  )
}
