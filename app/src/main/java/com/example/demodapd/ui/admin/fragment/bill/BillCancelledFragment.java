package com.example.demodapd.ui.admin.fragment.bill;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demodapd.R;
import com.example.demodapd.adapter.BillAdapter_2;
import com.example.demodapd.model.Bill;
import com.example.demodapd.network.ManagerService;
import com.example.demodapd.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillCancelledFragment extends Fragment {

    private RecyclerView rcv_cancelled;
    private BillAdapter_2 billAdapter;
    private List<Bill> billList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_cancelled, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv_cancelled = view.findViewById(R.id.rcv_bill_cancelled);
        billList = new ArrayList<>();
        billAdapter = new BillAdapter_2(billList, new BillAdapter_2.OnItemClickListener() {
            @Override
            public void onItemClick(String _id) {

            }
        });
        rcv_cancelled.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv_cancelled.setAdapter(billAdapter);
        fetchBill();
    }
    private void fetchBill() {
        ManagerService managerService = RetrofitClient.getService();
        Call<List<Bill>> call = managerService.getListBill();
        call.enqueue(new Callback<List<Bill>>() {
            @Override
            public void onResponse(Call<List<Bill>> call, Response<List<Bill>> response) {
                if (response.isSuccessful()) {
                    List<Bill> bills = response.body();
                    if (bills != null) {
                        billList.clear();
                        for (Bill bill : bills) {
                            if (bill.getStatusBill() == 2) {
                                billList.add(bill);
                            }
                        }
                        billAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Bill>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}