'use client';
import { XProduct } from '@/constants/data';
import { ColumnDef } from '@tanstack/react-table';
import Image from 'next/image';
import { CellAction } from './cell-action';

export const columns: ColumnDef<XProduct>[] = [
  {
    accessorKey: 'id',
    header: 'ID'
  },
  {
    accessorKey: 'img',
    header: 'IMAGEN',
    cell: ({ row }) => {
      return (
        <div className="relative aspect-square">
          <Image
            src={row.getValue('img')}
            alt={row.getValue('name')}
            fill
            className="rounded-lg"
          />
        </div>
      );
    }
  },
  {
    accessorKey: 'name',
    header: 'NOMBRE'
  },
  {
    accessorKey: 'description',
    header: 'DESCRPCIÓN'
  },
  {
    accessorKey: 'price',
    header: 'PRECIO'
  },
  {
    accessorKey: 'category',
    header: 'CATEGORIA'
  },

  {
    id: 'actions',
    cell: ({ row }) => <CellAction data={row.original} />
  }
];
