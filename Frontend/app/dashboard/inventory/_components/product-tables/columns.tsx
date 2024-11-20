'use client';
import { XProduct } from '@/constants/data';
import { ColumnDef } from '@tanstack/react-table';
import { CellAction } from './cell-action';

export const columns: ColumnDef<XProduct>[] = [
  {
    accessorKey: 'id',
    header: 'ID'
  },
  {
    accessorKey: 'name',
    header: 'NOMBRE'
  },
  {
    accessorKey: 'quantity',
    header: 'CANTIDAD'
  },
  {
    accessorKey: 'dateLastInventory',
    header: 'FCHA ULTIMO INVENTARIO'
  },
  {
    accessorKey: 'product.name',
    header: 'PRODUCTO'
  },

  {
    id: 'actions',
    cell: ({ row }) => <CellAction data={row.original} />
  }
];
