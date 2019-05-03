package y2k.virtual.ui.tea

import y2k.virtual.ui.VirtualHostView
import y2k.virtual.ui.VirtualNode

object SimpleTea {

    fun <Msg, Model> run(hostView: VirtualHostView, comp: TeaComponent<Msg, Model>) {
        var model = comp.init
        fun loop() {
            hostView.update {
                comp.view(model) {
                    model = comp.update(model, it)
                    loop()
                }
            }
        }
        loop()
    }
}

interface TeaComponent<Msg, Model> {
    val init: Model
    fun view(model: Model, dispatch: (Msg) -> Unit): VirtualNode
    fun update(model: Model, msg: Msg): Model
}
