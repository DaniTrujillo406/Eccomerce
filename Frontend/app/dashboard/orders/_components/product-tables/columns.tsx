'use client';
import { XProduct } from '@/constants/data';
import { ColumnDef } from '@tanstack/react-table';
import Image from 'next/image';
import { CellAction } from './cell-action';

export const columns: ColumnDef<XProduct>[] = [
  {
    accessorKey: 'state',
    header: 'ESTADO'
  },
  {
    accessorKey: 'customer.id',
    header: 'ID DE USUARIO'
  },
  {
    accessorKey: 'customer.name',
    header: 'NOMBRE DE USUARIO'
  },
  {
    accessorKey: 'totalPrice',
    header: 'PRECIO TOTAL'
  },
  {
    accessorKey: 'orderDate',
    header: 'FECHA DE ORDEN'
  },

  {
    id: 'actions',
    cell: ({ row }) => <CellAction data={row.original} />
  }
];
