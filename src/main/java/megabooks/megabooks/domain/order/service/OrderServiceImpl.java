package megabooks.megabooks.domain.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.order.dto.OrderRequestDTO;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;
import megabooks.megabooks.domain.order.repository.OrderRepository;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderResponseDTO.OrderCreateDTO create(OrderRequestDTO.OrderCreateDTO orderCreateDTO) {
        try {
            log.info("[OrderServiceImpl] create");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl create");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl create");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl create : " + e.getMessage());
        }
    }

    @Override
    public OrderResponseDTO.OrderFindOneDTO findOne(Long orderId) {
        try {
            log.info("[OrderServiceImpl] findOne");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl findOne");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl findOne : " + e.getMessage());
        }
    }

    @Override
    public OrderResponseDTO.OrderFindAllDTO findAll(String userEmail) {
        try {
            log.info("[OrderServiceImpl] findAll");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl findAll");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl findAll");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl findAll : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderResponseDTO.OrderCancelDTO cancel(Long orderId) {
        try {
            log.info("[OrderServiceImpl] cancel");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl cancel");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl cancel");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl cancel : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderResponseDTO.OrderConfirmedDTO confirmed(Long orderId) {
        try {
            log.info("[OrderServiceImpl] confirmed");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl confirmed");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl confirmed");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl confirmed : " + e.getMessage());
        }
    }
}
