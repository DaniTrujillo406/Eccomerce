import FormCardSkeleton from '@/components/form-card-skeleton';
import PageContainer from '@/components/layout/page-container';
import { Suspense } from 'react';
import ProductViewPage from '../_components/inventory-view-page';

export const metadata = {
  title: 'Dashboard : Inventory View'
};

type PageProps = { params: { inventoryId: string } };

export default function Page({ params }: PageProps) {
  return (
    <PageContainer scrollable>
      <div className="flex-1 space-y-4">
        <Suspense fallback={<FormCardSkeleton />}>
          <ProductViewPage productId={params.inventoryId} />
        </Suspense>
      </div>
    </PageContainer>
  );
}
