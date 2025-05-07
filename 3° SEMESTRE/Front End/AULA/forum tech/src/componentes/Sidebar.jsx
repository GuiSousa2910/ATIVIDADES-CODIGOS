import { useState } from 'react';
import { cn } from '../uteis/cn';
import { Button } from './Button';
import { FaListUl, FaSearch } from "react-icons/fa";

export const SideBar = () => {
  const [isOpen, setIsOpen] = useState(true);
  
  const toggleSidebar = () => {
    setIsOpen(prev => !prev);
  };

  return (
    <aside className={cn(
      'border h-screen transition-all flex flex-col duration-150 relative',
      isOpen ? 'w-64' : 'w-0'
    )}>
      <Button
        variant="ghost"
        onClick={toggleSidebar}
        className="rounded-full p-0 w-12 h-12 absolute top-[40%] -right-6 bg-white"
      >
        |||
      </Button>
      <div className={cn('relative overflow-x-hidden w-full')}>
        {isOpen && (
          <>
            <div className="flex justify-center items-center px-4 py-6">
              <div className="flex flex-col gap-y-2 relative">
                <div className='absolute top-3 left-2'><FaSearch /></div>
                <input
                  placeholder='Buscar'
                  className="px-4 py-2 bg-transparent pl-8 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
                />
              </div>
            </div>
            <div>
              <h3 className='text-[13px] text-ft-gray-white pl-6 py-2 font-medium'>Menu</h3>
              <ul>
                <li className='bg-ft-primary bg-opacity-20 px-5 py-3 font-semibold text-ft-secondary text-[13px] border-l-4 border-ft-secondary flex items-center gap-2'>
                  <FaListUl />
                  Perguntas
                </li>
              </ul>
            </div>
          </>
        )}
      </div>
    </aside>
  );
};